/*    */ package Koishi.cards.Skills.Uncommon;
/*    */ 
/*    */ import Koishi.KoishiMod;
/*    */ import Koishi.actions.MassHysteriaAction;
/*    */ import Koishi.cards.AbstractIdCard;
/*    */ import Koishi.characters.KoishiCharacter;
/*    */ import com.megacrit.cardcrawl.actions.AbstractGameAction;
/*    */ import com.megacrit.cardcrawl.cards.AbstractCard;
/*    */ import com.megacrit.cardcrawl.characters.AbstractPlayer;
/*    */ import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
/*    */ import com.megacrit.cardcrawl.monsters.AbstractMonster;
/*    */ 
/*    */ public class MassHysteria
/*    */   extends AbstractIdCard {
/* 15 */   public static final String ID = KoishiMod.makeID(MassHysteria.class.getSimpleName());
/* 16 */   public static final String IMG = KoishiMod.makeCardPath("MassHysteria.png");
/*    */   
/* 18 */   private static final AbstractCard.CardRarity RARITY = AbstractCard.CardRarity.UNCOMMON;
/* 19 */   private static final AbstractCard.CardTarget TARGET = AbstractCard.CardTarget.ALL_ENEMY;
/* 20 */   private static final AbstractCard.CardType TYPE = AbstractCard.CardType.SKILL;
/* 21 */   public static final AbstractCard.CardColor COLOR = KoishiCharacter.Enums.COLOR_DARK_GREEN;
/*    */   
/*    */   private static final int COST = 2;
/*    */   private static final int UPGRADED_COST = 1;
/*    */   
/*    */   public MassHysteria() {
/* 27 */     super(ID, IMG, 2, TYPE, COLOR, RARITY, TARGET);
/*    */   }
/*    */ 
/*    */   
/*    */   public void use(AbstractPlayer p, AbstractMonster m) {
/* 32 */     KoishiMod.runAnimation("spellC");
/* 33 */     AbstractDungeon.actionManager.addToBottom((AbstractGameAction)new MassHysteriaAction());
/*    */   }
/*    */ 
/*    */   
/*    */   public void upgrade() {
/* 38 */     if (!this.upgraded) {
/* 39 */       upgradeName();
/* 40 */       upgradeBaseCost(1);
/* 41 */       initializeDescription();
/*    */     } 
/*    */   }
/*    */ }


/* Location:              /home/voxelle/Desktop/Koishi.jar!/Koishi/cards/Skills/Uncommon/MassHysteria.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */