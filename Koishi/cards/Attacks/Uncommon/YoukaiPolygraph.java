/*    */ package Koishi.cards.Attacks.Uncommon;
/*    */ 
/*    */ import Koishi.KoishiMod;
/*    */ import Koishi.cards.AbstractDefaultCard;
/*    */ import Koishi.characters.KoishiCharacter;
/*    */ import Koishi.tags.Tags;
/*    */ import com.megacrit.cardcrawl.actions.AbstractGameAction;
/*    */ import com.megacrit.cardcrawl.actions.common.DamageAction;
/*    */ import com.megacrit.cardcrawl.actions.common.GainEnergyAction;
/*    */ import com.megacrit.cardcrawl.cards.AbstractCard;
/*    */ import com.megacrit.cardcrawl.cards.DamageInfo;
/*    */ import com.megacrit.cardcrawl.characters.AbstractPlayer;
/*    */ import com.megacrit.cardcrawl.core.AbstractCreature;
/*    */ import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
/*    */ import com.megacrit.cardcrawl.monsters.AbstractMonster;
/*    */ 
/*    */ public class YoukaiPolygraph
/*    */   extends AbstractDefaultCard
/*    */ {
/* 20 */   public static final String ID = KoishiMod.makeID(YoukaiPolygraph.class.getSimpleName());
/* 21 */   public static final String IMG = KoishiMod.makeCardPath("YoukaiPolygraph.png");
/*    */   
/* 23 */   private static final AbstractCard.CardRarity RARITY = AbstractCard.CardRarity.UNCOMMON;
/* 24 */   private static final AbstractCard.CardTarget TARGET = AbstractCard.CardTarget.ENEMY;
/* 25 */   private static final AbstractCard.CardType TYPE = AbstractCard.CardType.ATTACK;
/* 26 */   public static final AbstractCard.CardColor COLOR = KoishiCharacter.Enums.COLOR_DARK_GREEN;
/*    */   
/*    */   private static final int COST = 1;
/*    */   
/*    */   private static final int DAMAGE = 8;
/*    */   
/*    */   private static final int UPGRADE_PLUS_DMG = 3;
/*    */   private static final int ENERGY = 2;
/*    */   
/*    */   public YoukaiPolygraph() {
/* 36 */     super(ID, IMG, 1, TYPE, COLOR, RARITY, TARGET);
/* 37 */     this.baseDamage = 8;
/* 38 */     this.magicNumber = this.baseMagicNumber = 2;
/* 39 */     this.tags.add(Tags.DEBUFF_THIS_TURN);
/*    */   }
/*    */ 
/*    */   
/*    */   public void use(AbstractPlayer p, AbstractMonster m) {
/* 44 */     KoishiMod.runAnimation("occultAttack");
/* 45 */     AbstractDungeon.actionManager.addToBottom((AbstractGameAction)new DamageAction((AbstractCreature)m, new DamageInfo((AbstractCreature)p, this.damage, this.damageTypeForTurn), AbstractGameAction.AttackEffect.SLASH_HORIZONTAL));
/* 46 */     if (KoishiMod.appliedDebuffThisTurn) {
/* 47 */       AbstractDungeon.actionManager.addToBottom((AbstractGameAction)new GainEnergyAction(this.magicNumber));
/*    */     }
/*    */   }
/*    */   
/*    */   public void triggerOnGlowCheck() {
/* 52 */     this.glowColor = AbstractCard.BLUE_BORDER_GLOW_COLOR.cpy();
/* 53 */     if (KoishiMod.appliedDebuffThisTurn) {
/* 54 */       this.glowColor = AbstractCard.GOLD_BORDER_GLOW_COLOR.cpy();
/*    */     }
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public float getTitleFontSize() {
/* 61 */     return 20.0F;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public void upgrade() {
/* 67 */     if (!this.upgraded) {
/* 68 */       upgradeName();
/* 69 */       upgradeDamage(3);
/* 70 */       initializeDescription();
/*    */     } 
/*    */   }
/*    */ }


/* Location:              /home/voxelle/Desktop/Koishi.jar!/Koishi/cards/Attacks/Uncommon/YoukaiPolygraph.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */