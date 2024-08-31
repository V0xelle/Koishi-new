/*    */ package Koishi.cards.Attacks.Rare;
/*    */ 
/*    */ import Koishi.KoishiMod;
/*    */ import Koishi.cards.AbstractDefaultCard;
/*    */ import Koishi.characters.KoishiCharacter;
/*    */ import Koishi.tags.Tags;
/*    */ import com.megacrit.cardcrawl.actions.AbstractGameAction;
/*    */ import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
/*    */ import com.megacrit.cardcrawl.actions.common.DamageAction;
/*    */ import com.megacrit.cardcrawl.cards.AbstractCard;
/*    */ import com.megacrit.cardcrawl.cards.DamageInfo;
/*    */ import com.megacrit.cardcrawl.characters.AbstractPlayer;
/*    */ import com.megacrit.cardcrawl.core.AbstractCreature;
/*    */ import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
/*    */ import com.megacrit.cardcrawl.monsters.AbstractMonster;
/*    */ import com.megacrit.cardcrawl.powers.AbstractPower;
/*    */ 
/*    */ public class RuptureMind
/*    */   extends AbstractDefaultCard
/*    */ {
/* 21 */   public static final String ID = KoishiMod.makeID(RuptureMind.class.getSimpleName());
/* 22 */   public static final String IMG = KoishiMod.makeCardPath("RuptureMind.png");
/*    */   
/* 24 */   private static final AbstractCard.CardRarity RARITY = AbstractCard.CardRarity.RARE;
/* 25 */   private static final AbstractCard.CardTarget TARGET = AbstractCard.CardTarget.ENEMY;
/* 26 */   private static final AbstractCard.CardType TYPE = AbstractCard.CardType.ATTACK;
/* 27 */   public static final AbstractCard.CardColor COLOR = KoishiCharacter.Enums.COLOR_DARK_GREEN;
/*    */   
/*    */   private static final int COST = 1;
/*    */   
/*    */   private static final int DAMAGE = 10;
/*    */   
/*    */   private static final int UPGRADE_PLUS_DMG = 3;
/*    */   private static final int DEBUFF = 2;
/*    */   private static final int UPGRADE_PLUS_DEBUFF = 1;
/*    */   
/*    */   public RuptureMind() {
/* 38 */     super(ID, IMG, 1, TYPE, COLOR, RARITY, TARGET);
/* 39 */     this.baseDamage = 10;
/* 40 */     this.magicNumber = this.baseMagicNumber = 2;
/* 41 */     this.tags.add(Tags.DEBUFF_THIS_TURN);
/*    */   }
/*    */ 
/*    */   
/*    */   public void use(AbstractPlayer p, AbstractMonster m) {
/* 46 */     KoishiMod.runAnimation("occultAttack");
/* 47 */     AbstractDungeon.actionManager.addToBottom((AbstractGameAction)new DamageAction((AbstractCreature)m, new DamageInfo((AbstractCreature)p, this.damage, this.damageTypeForTurn), AbstractGameAction.AttackEffect.FIRE));
/* 48 */     if (KoishiMod.appliedDebuffThisTurn) {
/* 49 */       for (AbstractPower debuff : m.powers) {
/* 50 */         if (debuff.type == AbstractPower.PowerType.DEBUFF) {
/* 51 */           if (debuff.canGoNegative) {
/* 52 */             AbstractDungeon.actionManager.addToBottom((AbstractGameAction)new ApplyPowerAction((AbstractCreature)m, (AbstractCreature)p, debuff, -this.magicNumber)); continue;
/*    */           } 
/* 54 */           AbstractDungeon.actionManager.addToBottom((AbstractGameAction)new ApplyPowerAction((AbstractCreature)m, (AbstractCreature)p, debuff, this.magicNumber));
/*    */         } 
/*    */       } 
/*    */     }
/*    */   }
/*    */ 
/*    */   
/*    */   public void triggerOnGlowCheck() {
/* 62 */     this.glowColor = AbstractCard.BLUE_BORDER_GLOW_COLOR.cpy();
/* 63 */     if (KoishiMod.appliedDebuffThisTurn) {
/* 64 */       this.glowColor = AbstractCard.GOLD_BORDER_GLOW_COLOR.cpy();
/*    */     }
/*    */   }
/*    */ 
/*    */   
/*    */   public void upgrade() {
/* 70 */     if (!this.upgraded) {
/* 71 */       upgradeName();
/* 72 */       upgradeDamage(3);
/* 73 */       upgradeMagicNumber(1);
/* 74 */       initializeDescription();
/*    */     } 
/*    */   }
/*    */ }


/* Location:              /home/voxelle/Desktop/Koishi.jar!/Koishi/cards/Attacks/Rare/RuptureMind.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */