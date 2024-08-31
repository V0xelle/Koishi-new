/*    */ package Koishi.cards.Attacks.Uncommon;
/*    */ 
/*    */ import Koishi.KoishiMod;
/*    */ import Koishi.cards.AbstractDefaultCard;
/*    */ import Koishi.characters.KoishiCharacter;
/*    */ import Koishi.tags.Tags;
/*    */ import com.megacrit.cardcrawl.actions.AbstractGameAction;
/*    */ import com.megacrit.cardcrawl.actions.common.DamageAction;
/*    */ import com.megacrit.cardcrawl.actions.common.GainBlockAction;
/*    */ import com.megacrit.cardcrawl.cards.AbstractCard;
/*    */ import com.megacrit.cardcrawl.cards.DamageInfo;
/*    */ import com.megacrit.cardcrawl.characters.AbstractPlayer;
/*    */ import com.megacrit.cardcrawl.core.AbstractCreature;
/*    */ import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
/*    */ import com.megacrit.cardcrawl.monsters.AbstractMonster;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class TraumaticStroke
/*    */   extends AbstractDefaultCard
/*    */ {
/* 22 */   public static final String ID = KoishiMod.makeID(TraumaticStroke.class.getSimpleName());
/* 23 */   public static final String IMG = KoishiMod.makeCardPath("TraumaticStroke.png");
/*    */   
/* 25 */   private static final AbstractCard.CardRarity RARITY = AbstractCard.CardRarity.UNCOMMON;
/* 26 */   private static final AbstractCard.CardTarget TARGET = AbstractCard.CardTarget.ENEMY;
/* 27 */   private static final AbstractCard.CardType TYPE = AbstractCard.CardType.ATTACK;
/* 28 */   public static final AbstractCard.CardColor COLOR = KoishiCharacter.Enums.COLOR_DARK_GREEN;
/*    */   
/*    */   private static final int COST = 2;
/*    */   
/*    */   private static final int DAMAGE = 14;
/*    */   
/*    */   private static final int UPGRADE_PLUS_DMG = 4;
/*    */   private static final int BLOCK = 14;
/*    */   private static final int UPGRADE_PLUS_BLOCK = 4;
/*    */   
/*    */   public TraumaticStroke() {
/* 39 */     super(ID, IMG, 2, TYPE, COLOR, RARITY, TARGET);
/* 40 */     this.baseDamage = 14;
/* 41 */     this.baseBlock = 14;
/* 42 */     this.tags.add(Tags.DEBUFF_THIS_TURN);
/*    */   }
/*    */ 
/*    */   
/*    */   public void use(AbstractPlayer p, AbstractMonster m) {
/* 47 */     KoishiMod.runAnimation("airAttack");
/* 48 */     AbstractDungeon.actionManager.addToBottom((AbstractGameAction)new DamageAction((AbstractCreature)m, new DamageInfo((AbstractCreature)p, this.damage, this.damageTypeForTurn), AbstractGameAction.AttackEffect.BLUNT_HEAVY));
/* 49 */     if (KoishiMod.appliedDebuffThisTurn) {
/* 50 */       AbstractDungeon.actionManager.addToBottom((AbstractGameAction)new GainBlockAction((AbstractCreature)p, (AbstractCreature)p, this.block));
/*    */     }
/*    */   }
/*    */   
/*    */   public void triggerOnGlowCheck() {
/* 55 */     this.glowColor = AbstractCard.BLUE_BORDER_GLOW_COLOR.cpy();
/* 56 */     if (KoishiMod.appliedDebuffThisTurn) {
/* 57 */       this.glowColor = AbstractCard.GOLD_BORDER_GLOW_COLOR.cpy();
/*    */     }
/*    */   }
/*    */ 
/*    */   
/*    */   public void upgrade() {
/* 63 */     if (!this.upgraded) {
/* 64 */       upgradeName();
/* 65 */       upgradeDamage(4);
/* 66 */       upgradeBlock(4);
/* 67 */       initializeDescription();
/*    */     } 
/*    */   }
/*    */ }


/* Location:              /home/voxelle/Desktop/Koishi.jar!/Koishi/cards/Attacks/Uncommon/TraumaticStroke.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */